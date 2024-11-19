import logo from './logo.svg';
import './App.css';
import {useEffect} from "react";

export default function App() {

    useEffect(() => {
        fetch('http://localhost:8080/react')
            .then(response=>response.text())
            .then(result=>console.log(result))
    }, []);
  return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo"/>
          <p>
            Hello!
          </p>
        </header>
      </div>
  );
}
