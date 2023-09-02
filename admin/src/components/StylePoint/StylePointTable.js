import React from 'react';
import { Link } from 'react-router-dom';

function StylePointTable({ stylePoint }) {
  return (
    <tr>
      <td>{stylePoint.id}</td>
      <td><Link to={`/stylepoint/${stylePoint.id}`} className="btn btn-title">{stylePoint.title}</Link></td>
      <td>{stylePoint.description}</td>
      <td><img src={stylePoint.image} alt={stylePoint.title} /></td>
    </tr>
  );
}
export default StylePointTable;
