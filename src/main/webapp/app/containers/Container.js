import React from 'react'
import ChatView from './../views/ChatView'

export default class Container extends React.Component {
    constructor() {
        super();
        this.state = {
            messages: [],
            userName: ''
        }

    }

    render() {
        return (
            <div>
            <ChatView />
            </div>
        )
    }
}