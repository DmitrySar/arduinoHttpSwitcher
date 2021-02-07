const url = "http://" + location.host + "/";
const TIMEOUT = 2000;

function startAsync() {
    setInterval(() => {
        doGet("12");
        doGet("22");
    }, TIMEOUT);
}

function check(id) {
    let chBox = document.getElementById(id);
    if (chBox.checked) {
        doGet(id + "1");
    } else {
        doGet(id + "0");
    }
}

function doCheck(id, flag) {
    let chBox = document.getElementById(id);
    chBox.checked = flag == "1" ? true : false;
    // check(id);
}

function doGet(id) {
    fetch(url + id).then(function (response) {
        if (response.ok) {
            response.text().then(function (r) {
                switch (id) {
                    case "10":
                        toLog("Выкл 1 ");
                        break;
                    case "11":
                        toLog("Вкл 1 ");
                        break;
                    case "20":
                        toLog("Выкл 2 ");
                        break;
                    case "21":
                        toLog("Вкл 2 ");
                        break;
                    case "12":
                        doCheck("1", r);
                        break;
                    case "22":
                        doCheck("2", r);
                }
            });
        } else {
            console.log(status);
        }
    });
}

function toLog(message) {
    document.getElementById("log").innerText = message;
}