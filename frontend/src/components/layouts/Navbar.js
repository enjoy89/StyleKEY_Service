import React from 'react';
import { Link } from 'react-router-dom';

function Navbar() {
  return (
    <nav>
      <Link to='/test'>TEST</Link>
      <Link to='/stylepoints'>STYLE</Link>
    </nav>
  );
}

export default Navbar;
