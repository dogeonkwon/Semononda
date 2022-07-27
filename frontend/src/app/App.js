import { Route, Routes } from 'react-router-dom';
import About from '../features/about/About';
import Home from '../features/home/Home';
import Game from '../features/game/Game'

const App = () => {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/about" element={<About />} />
      <Route path="/game/:id" element={<Game />} />
    </Routes>
  );
};

export default App;