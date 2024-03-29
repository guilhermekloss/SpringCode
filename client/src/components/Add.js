import React, { Component } from 'react';
import {Button} from 'react-bootstrap'
import Alert from 'react-s-alert';
import './AddView.css';
import { postNewPost } from './API'

class Add extends Component{

	constructor(props) {
		super(props);
	  	this.state = {
			text: ''
	  	};
  	}

	updateAuthor(evt){
		this.setState({
		  author: evt.target.value
		});
	}

	updateText(evt){
		this.setState({
		  text: evt.target.value
		});
	}

	createPost() {
		const params = new URLSearchParams();
		params.append('texto', this.state.texto);

		postNewPost(params).then(res => {
			this.setState({
				texto: ''
			});
	        Alert.info('Comentário adicionado com sucesso',{
	        	position: 'bottom-right'
	        });
		}).catch(error =>{
	        Alert.error('Erro ao tentar criar post!',{
	        	position: 'bottom-right'
	        });
  		});
	}

	render() {
    	return (
		<div className="container">
			<div className="jumbotron jumbo">
				<Alert stack={{limit: 2}} />
				<div className="form-group">
					<label>Comentário:</label>
					<textarea maxlength="250" className="form-control" rows="5" id="comment" onChange={evt => this.updateText(evt)} value={this.state.text}></textarea>
				</div>
			</div>  
				<div className="adicionar">
					<Button 
					onClick={this.createPost.bind(this)}
					>Adicionar</Button>
				</div>
		</div>
    	);
  	}	
}
export default Add;