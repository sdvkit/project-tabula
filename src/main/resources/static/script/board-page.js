'use strict'

let currentTaskGroup;

const basicModalHeader = document.getElementById('new-task-span');
const taskGroups = document.querySelectorAll('.task-group');
const boardPage = document.getElementById('add-task-modal');
const datePicker = document.getElementById('task-expiration');
const taskDescriptionInput = document.getElementById('task-description');
const taskNameInput = document.getElementById('task-name');

const addGroupModal = document.getElementById('add-task-group-modal');
const groupAdder = document.querySelector('.task-group-adder');
const saveGroupButton = document.getElementById('save-group-button');

groupAdder.onclick = () => {
    addGroupModal.style.display = 'block';
}

datePicker.onfocus = () => {
    datePicker.type = 'date';
    const currentDate = new Date();
    const preValue = new Date(datePicker.value);

    let currentDateMonth = ((currentDate.getMonth() + 1).toString().length === 1) ? '0' + (currentDate.getMonth() + 1) : (currentDate.getMonth() + 1);
    let currentDateDay = (currentDate.getDate().toString().length === 1) ? '0' + currentDate.getDate() : currentDate.getDate();
    let preDateMonth = ((preValue.getMonth() + 1).toString().length === 1) ? '0' + (preValue.getMonth() + 1) : (preValue.getMonth() + 1);
    let preDateDay = (preValue.getDate().toString().length === 1) ? '0' + preValue.getDate() : preValue.getDate();

    datePicker.value = (preValue.toString() === 'Invalid Date')
        ? `${currentDate.getFullYear()}-${currentDateMonth}-${currentDateDay}`
        : `${preValue.getFullYear()}-${preDateMonth}-${preDateDay}`;
    datePicker.min = datePicker.value;
}

taskGroups.forEach(taskGroup => {
    let plusButton = taskGroup.querySelector('.group-header .bx-plus');
    plusButton.onclick = () => {
        boardPage.style.display = 'block';
        currentTaskGroup = taskGroup;
        basicModalHeader.textContent = `New task for ${currentTaskGroup.querySelector('.group-name').textContent}`;
    };
});

window.onclick = (evt) => {
    if (evt.target === boardPage) {
        boardPage.style.display = 'none';
        datePicker.type = 'text';
        datePicker.value = '';
        taskNameInput.value = '';
        taskDescriptionInput.value = '';
    } else if (evt.target === addGroupModal) {
        addGroupModal.style.display = 'none';
    }
}

window.onkeydown = (evt) => {
    if (boardPage.style.display === 'block') {
        if (evt.key === 'Enter' && document.activeElement.id !== 'task-description') {

            const currentDate = new Date();
            let currentDateMonth = ((currentDate.getMonth() + 1).toString().length === 1) ? '0' + (currentDate.getMonth() + 1) : (currentDate.getMonth() + 1);
            let currentDateDay = (currentDate.getDate().toString().length === 1) ? '0' + currentDate.getDate() : currentDate.getDate();

            let task = document.createElement('div');
            task.classList.add('task');
            task.id = `task`;
            task.draggable = true;
            task.innerHTML =
                `<div class="task-header">
                    <span>${taskNameInput.value}</span>
                    <i class='bx bx-dots-vertical-rounded'></i>
                </div>
                <div class="task-content">
                    <ul>
                        <li class="description">
                            ${taskDescriptionInput.value}
                        </li>
                        <li class="creation">
                            <i class='bx bx-calendar'></i>
                                ${currentDateDay}.${currentDateMonth}.${currentDate.getFullYear()}
                        </li>
                    </ul>
                </div>`;
            currentTaskGroup.querySelector('.tasks-container').appendChild(task);
        }
    }
}

saveGroupButton.onclick = () => {
    let taskGroup = document.createElement('div');
    taskGroup.classList.add('task-group');
    taskGroup.id = `taskGroup${taskGroupId}`;
    taskGroup.innerHTML =
        `<div class="group-header">
            <i class='bx bx-health'></i>
            <span class="group_name">Task Group ${taskGroupId++}</span>
            <i class='bx bx-plus'></i>
        </div>
            <div class="tasks_container">
            </div>`;
    taskGroups[0].parentElement.appendChild(taskGroup);
}