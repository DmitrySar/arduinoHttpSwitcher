/* Arduino command:
 * 10 - sw1 off
 * 11 - sw1 on
 * 20 - sw2 off
 * 21 - sw2 on
 * 12 - get status sw1
 * 22 - get status sw2
 */

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

function onClickSw(id) {
    let chBox = document.getElementById(id);
    chBox.checked = !chBox.checked;
    check(id);
}

function doCheck(id, flag) {
    let chBox = document.getElementById(id);
    let key = flag == "1" ? true : false;
    chBox.checked = key;
    switchLamp('lamp' + id, key);
}

function switchLamp(id, flag) {
    let srcImg = flag ? 'img/high.png' : 'img/low.png';
    document.getElementById(id).src = srcImg;
}

function doGet(id) {
    fetch(url + id).then(function (response) {
        if (response.ok) {
            response.text().then(function (r) {
                switch (id) {
                    case "10":
                        switchLamp('lamp1', false);
                        break;
                    case "11":
                        switchLamp('lamp1', true);
                        break;
                    case "20":
                        switchLamp('lamp2', false);
                        break;
                    case "21":
                        switchLamp('lamp2', true);
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