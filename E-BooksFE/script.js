// function openPopup() {
//     document.getElementById("loginPopup").style.display = "flex";
// }

// function closePopup() {
//     document.getElementById("loginPopup").style.display = "none";
// }

function openPopup() {
    document.getElementById("loginPopup").style.display = "flex";
}

function openRegisterPopup() {
    document.getElementById("registerPopup").style.display = "flex";
}

function closePopup() {
    document.getElementById("loginPopup").style.display = "none";
    document.getElementById("registerPopup").style.display = "none";
}

// Switch from login to register popup
function switchToRegister() {
    closePopup();
    openRegisterPopup();
}

// Switch from register to login popup
function switchToLogin() {
    closePopup();
    openLoginPopup();
}

