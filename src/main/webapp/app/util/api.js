import axios from 'axios'

const URL = 'http://localhost:8888/chat';

export function saveMessage(message) {
    return axios.post(URL, message)
        .catch((error) => {
            console.log(error);
        })
}

export function getUserName() {
    return axios.get(URL)
        .catch((error) => {
            console.log(error)
        });
}

export function getLastMessageId() {
    return axios.get(URL + '/lastMessageId')
        .catch((error) => {
            console.log(error);
        });
}

export function fetchMessages(user, messageId) {
    
}