'use strict'

let sidebar = document.querySelector('.sidebar');
let closeBtn = document.querySelector('#btn');

closeBtn.onclick = ()=>{
    sidebar.classList.toggle('open');
    if(sidebar.classList.contains('open')){
        closeBtn.classList.replace('bx-menu', 'bx-menu-alt-right');
    }else {
        closeBtn.classList.replace('bx-menu-alt-right','bx-menu');
    }
};