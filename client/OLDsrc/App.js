import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {




		state = {
			posts: [],
			isLoaded: false,
		}
	

	componentDidMount(){
		
		fech('http://localhost:8080/api/textos')
		.then(res => res.json())
		.then(json => {
			this.setState({
				isLoaded: true,
				posts: json,
			})
		});
		
	}


	render() {

		var{isLoaded, itens} = this.state;
		if(!isLoaded){
			return <div>Carregendo...</div>;
		}
		else{
			return (
		      <div className="App">
		      	dado carregado
		      </div>
		    );
		}

	}

}

export default App;
