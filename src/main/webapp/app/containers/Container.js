import React from 'react'
import ChatView from './../views/ChatView'
import {saveMessage, getUserName, getLastMessageId} from './../util/api.js'

export default class Container extends React.Component {
    constructor() {
        super();
        this.state = {
            messages: [],
            userName: '',
            inputText: '',
            lastMessageId: 0
        }

    }

    componentWillMount() {
        getUserName().then((response) => {
            this.setState({
                userName: response.data
            });
        });
    }

    handleKeyPress(e) {
        if (e.key === 'Enter') {
            let message = {};
            let text = e.target.value;
            getLastMessageId().then((response) => {
                let id = response.data;
                message.id = id;
                message.text = text;
                message.userName = this.state.userName;
                console.log(message);
                saveMessage(message);
            });
        }
    }

    render() {
        return (
            <div>
                <ChatView
                    handleKeyPress={(event) => this.handleKeyPress(event) }
                    textValue={this.state.inputText}
                    messages={this.state.messages}
                    />
            </div>
        )
    }
}