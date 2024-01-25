import React from 'react';
import { Link } from 'react-router-dom';

function StylePointTableRow() {
  return (
    <tr>
      <th>id</th>
      <th>title</th>
      <th>description</th>
      <th>image</th>
      <th>edit</th>
    </tr>
  );
}

function StylePointTable({ stylePoint }) {
  return (
    <tr>
      <td>{stylePoint.id}</td>
      <td><Link to={`/style-points/${stylePoint.id}`} className="btn btn-title">{stylePoint.title}</Link></td>
      <td>{stylePoint.description}</td>
      <td><img src={stylePoint.image} alt={stylePoint.title} /></td>
      <td><a href={`/style-points/${stylePoint.id}/edit`} className="btn btn-edit">edit</a></td>
    </tr>
  );
}

function StylePointTableMap({ stylePoints }) {
  return (
    <div>
      <table>
        <thead>
          <StylePointTableRow />
        </thead>
        <tbody>
          {stylePoints && stylePoints.map((stylePoint) => (
            <StylePointTable key={stylePoint.id} stylePoint={stylePoint} />
          ))}
        </tbody>
      </table>
    </div>
  );
}

function StylePointTableSingle({ stylePoint }) {
  return (
    <div>
      <table>
        <thead>
          <StylePointTableRow />
        </thead>
        <tbody>
          <StylePointTable key={stylePoint.id} stylePoint={stylePoint} />
        </tbody>
      </table>
    </div>
  );
}

export { StylePointTableMap, StylePointTableSingle };
