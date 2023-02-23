'use strict'

const addBoardModal = document.getElementById('add-board-modal');
const groupAdder = document.querySelector('.board_adder');
const saveBoardButton = document.getElementById('save-board-button');

groupAdder.onclick = () => {
    addBoardModal.style.display = 'block';
}

window.onclick = (evt) => {
    if (evt.target === addBoardModal) {
        addBoardModal.style.display = 'none';
    }
}

saveBoardButton.onclick = () => {
    alert(10);
}