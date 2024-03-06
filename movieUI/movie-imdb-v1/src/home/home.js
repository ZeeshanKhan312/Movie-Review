import React from 'react';
import Hero from './hero';

const Home=({movies})=>{
    return(
        <Hero movies={movies}/>
    )
}

export default Home;