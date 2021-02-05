const url = 'http://192.168.1.63';

function check(id) {
    let chBox = document.getElementById(id);
    if (chBox.checked) {
        doGet(id + "1");
    } else {
        doGet(id + "0");
    }
}

function doGet(id) {
    fetch(url + "/" + id).then(function (response) {
        if (response.status == 0) {
            console.log(response.url);
            response.text().then(function (r) {
                switch (id) {
                    case "10":
                        toLog("Выкл 1");
                        break;
                    case "11":
                        toLog("Вкл 1");
                        break;
                    case "20":
                        toLog("Выкл 2");
                        break;
                    case "21":
                        toLog("Вкл 2");
                        break;
                    default: toLog(r);
                }
            });
        } else {
            toLog(response.status);
        }
    });
}

function toLog(message) {
    document.getElementById("log").innerText = message;
}