import React from 'react'

const ChatView = props => {
    let messages = props.messages.map((message) => {
        return (
            <li key={message.id}> message.userName : message.text </li> 
        )
    });

    return (
        <div>
            <ul>
                {messages}
            </ul>
            <input type="text" 
                placeholder="Enter your message..."
                onKeyPress={props.handleKeyPress}
                defaultValue={props.textValue} />
        </div>
    )
}

export default ChatView;