import React, { useState, useEffect } from 'react';
import axios from 'axios';
import ItemTableRow from './ItemTableRow';
import ItemTable from './ItemTable';

function ItemList({ coordiLookId }) {

  const [items, setItems] = useState([]);

  useEffect(() => {
    const fetchItems = async () => {
      try {
        const response = await axios.get('/admin/items');
        setItems(response.data.content);
      } catch (error) {
        console.error('Error fetching items', error);
      }
    };
    fetchItems();
  }, []);


  return (
    <div>
      <h2>items</h2>
      <table>
        <thead>
          <ItemTableRow />
        </thead>
        <tbody>
          {items && items.map(item => (
            <ItemTable key={item.id} item={item} />
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ItemList;
