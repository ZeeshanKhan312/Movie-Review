import './App.css';
import api from './axiosConfig';
import { useState,useEffect } from 'react';
import Layout from './home/layout';
import {Routes,Route} from 'react-router-dom';
import Home from './home/home';
import Header from './header';

function App() {
  const [movies,setMovies]=useState();


  const getMovies=async()=>{
    try {
      const res=await api.get("/api/movies");
      console.log(res.data);
      setMovies(res.data);
    } catch (error) {
      console.log(error);
    }
  }

  useEffect(()=>{
    getMovies();
  },[]);

  return (
    <div className="App">
     <Header/>
     <Routes>
        <Route path="/" element={<Layout/>}>
        <Route path="/" element={<Home movies={movies}/>}></Route>
        </Route>
     </Routes>
    </div>
  );
}

export default App;
