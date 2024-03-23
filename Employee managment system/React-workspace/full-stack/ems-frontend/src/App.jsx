import './App.css'
import ListEmpolyeeComponent from './components/ListEmpolyeeComponent'
import HeaderComponent from './components/HeaderComponent'
import FooterComponent from './components/FooterComponent'
import EmployeeComponent from './components/EmployeeComponent'
<<<<<<< HEAD
import {BrowserRouter, Routes, Route} from 'react-router-dom'
=======
import {BrowserRouter, Routes, Route,} from 'react-router-dom'
import ContentComponent from './components/ContentComponent'
>>>>>>> 0ee4cc3 (Update 1.0)
 
function App() {

  return (
    <>
    <BrowserRouter>
        <HeaderComponent/>
          <Routes>
              {/* http://localhost:3000 */}
<<<<<<< HEAD
            <Route path='/' element = {<HeaderComponent/>}></Route>
              {/* http://localhost:3000/employees */}
=======
              <Route path='/' element = {<ContentComponent/>}></Route>
              {/* http://localhost:3000/employees*/}
>>>>>>> 0ee4cc3 (Update 1.0)
            <Route path='/employees' element = {<ListEmpolyeeComponent/>}></Route>
              {/* http://localhost:3000/add-employee */}
            <Route path='/add-employee' element = {<EmployeeComponent/>}></Route>
              {/* http://localhost:3000/edit-employee/1 */}
            <Route path='/edit-employee/:id' element = {<EmployeeComponent/>}></Route>
          </Routes>
        <FooterComponent/>
    </BrowserRouter>
    </>
  )
}

export default App
