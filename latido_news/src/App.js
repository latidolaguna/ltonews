import React from 'react';
import Login from './login/Login'
import './App.css';

function App() {
  return (

    <div className="App">

      <link
        rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossOrigin="anonymous" />

      <Login />
    </div>
  );
}

export default App;