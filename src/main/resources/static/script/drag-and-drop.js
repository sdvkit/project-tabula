'use strict'

const taskContainers = document.querySelectorAll('.tasks-container');
let selectedTask;
let lastTaskGroup;

taskContainers.forEach(taskContainer => {

    taskContainer.ondragstart = (evt) => {
        selectedTask = evt.target;
    }

    taskContainer.ondragleave = (evt) => {
        evt.target.classList.remove('drag-over');
    }

    taskContainer.ondrop = (evt) => {
        taskContainer.append(selectedTask);
        evt.target.classList.remove('drag-over');
    }

    taskContainer.ondragover = (evt) => {
        evt.preventDefault();
    }

    taskContainer.ondragenter = (evt) => {
        if (evt.target.className === 'tasks-container') {
            evt.target.classList.add('drag-over');
            lastTaskGroup = evt.target.parentElement;
        }
    }
});

