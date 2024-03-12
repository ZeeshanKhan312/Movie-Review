import './App.css';
import api from './axiosConfig';
import { useState,useEffect } from 'react';
import Layout from './home/layout';
import {Routes,Route} from 'react-router-dom';
import Home from './home/home';
import Header from './header';
import Trailer from './home/trailer'
import Reviews from './reviewFile/review';
import notFound from './notFound';
function App() {
  const [movies,setMovies]=useState();
  const[movie,setMovie]=useState();
  const[reviews,setReviews]=useState();

  const getMovies=async()=>{
    try {
      const res=await api.get("/api/movies");
      console.log(res.data);
      setMovies(res.data);
    } catch (error) {
      console.log(error);
    }
  }
  const getMovieData=async(imdbId)=>{
    try {
      const res=await api.get(`/api/movies/${imdbId}`);
      const singleMovie=res.data
      setMovie(singleMovie);
      
      setReviews(singleMovie.reviewIds);
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
        <Route path="/Trailer/:ytTrailerId" element={<Trailer/>}></Route>
        <Route path="/api/movies/:imdbId/reviews" element ={<Reviews getMovieData = {getMovieData} movie={movie} reviews ={reviews} setReviews = {setReviews} />}></Route>
        <Route path="*" element = {<notFound/>}></Route>
        </Route>
     </Routes>
    </div>
  );
}

export default App;
