import React from 'react'

const ChatView = props => {
    return (
        <div>
            <ul>
            </ul>
            <input type="text" 
                placeholder="Enter your message..."
                onKeyPress={props.handleKeyPress}
                defaultValue={props.textValue} />
        </div>
    )
}

export default ChatView;