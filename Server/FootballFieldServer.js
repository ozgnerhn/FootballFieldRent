var io = require('socket.io')(8000);
console.log('Runningg');
var fs = require('fs');
var content = fs.readFileSync('data.json', 'utf8');

var tempData = {};
tempData = JSON.parse(content);
fs = require('fs');

function write() {
    fs.writeFile('./data.json', JSON.stringify(tempData), 'utf8', function (error) {
        if (error) {
            throw error;
        }
    })
}

content = fs.readFileSync('dataField.json', 'utf8');

var tempDataField = {};
tempDataField = JSON.parse(content);
fs = require('fs');

function writeField() {
    fs.writeFile('./dataField.json', JSON.stringify(tempDataField), 'utf8', function (error) {
        if (error) {
            throw error;
        }
    })
}

io.on('connection', function (socket) {

    socket.on('Login', function (data) {
	console.log("login");
        if (tempData[data.UserID]!=undefined&&tempData[data.UserID].UserID === data.UserID &&
            tempData[data.UserID].Password === data.Password) {
            console.log("login true");
            data.Name = tempData[data.UserID].Name;
            data.IsAdmin = tempData[data.UserID].IsAdmin;
            data.IsLogin = true;
        }
        else {
            console.log("login false");
            data.IsLogin = false;
        }
        io.to(socket.id).emit('LOGIN', data);
    });

    socket.on('UserCreate', function (data) {
	    console.log("userCreate");
        if (tempData[data.UserID] === undefined) {
	        console.log("userCreate True");
            tempData[data.UserID] = {};
            tempData[data.UserID].Name = data.Name;
            tempData[data.UserID].UserID = data.UserID;
            tempData[data.UserID].Password = data.Password;
            tempData[data.UserID].Mail = data.Mail;
            tempData[data.UserID].Phone = data.Phone;
            tempData[data.UserID].IsAdmin = data.IsAdmin;
            tempData[data.UserID].Fields=[];
            write();
            data.Create = true;
        }
        else {
            console.log("userCreate False");
            data.Create = false;
        }
        io.to(socket.id).emit('USERCREATE', data);
    });

    socket.on('FieldCreate', function (data) {
        if (tempDataField[data.Name] === undefined||data.Create===false) {
            tempDataField[data.Name] = {};
            tempDataField[data.Name].Name = data.Name;
            tempDataField[data.Name].City = data.City;
            tempDataField[data.Name].District = data.District;
            tempDataField[data.Name].Street = data.Street;
            tempDataField[data.Name].Since = data.Since;
            tempDataField[data.Name].Price = data.Price;
            tempDataField[data.Name].GrassType = data.GrassType;
            tempDataField[data.Name].Time=[];
            writeField();
            data.Create = true;
        }
        else {
            data.Create = false;
        }
        io.to(socket.id).emit('FIELDCREATE', data);
    });

    socket.on('ShowField', function (data) {
        var newData = [];
        for(fields in tempDataField)
        {
            if (data.City === fields[1]
                && data.District === fields[2]
                && data.Street === fields[3]&&data.Piece===3) {
                newData.push(data);
            }
            else if (data.City === fields[1]
                && data.District === fields[2]&&data.Piece===2) {
                newData.push(data);
            }
            else if (data.City === fields[1]&&data.Piece===1) {
                newData.push(data);
            }
        }
        data = JSON.stringify(newData);
        io.to(socket.id).emit('SHOWFIELD', data);
    });

    socket.on('ShowFieldTime', function (data) {
        var newData = {};
        for (var i = 0; i < 8; i++) {
            if (tempDataField[data.FieldName].Time[i]===undefined||
                tempDataField[data.FieldName].Time[i] === false) {
                newData[i] = true;
                newData[data.FieldName] = data[data.FieldName];
            }
            else {
                newData[i] = false;
            }
        }
        data = JSON.stringify(newData);
        io.to(socket.id).emit('SHOWFIELDTIME', data);
    });

    socket.on('MakeFullField', function (data) {
        if (tempDataField[data.FieldName].Time[data.Time]===undefined||
            tempDataField[data.FieldName].Time[data.Time] === false) {
            tempDataField[data.FieldName].Time[data.Time] === true;
            data.Reserve = true;
            tempData[data.UserID].Fields.push(data.FieldName, "&", data.Time);
        }
        else {
            data.Reserve = false;
        }
        io.to(socket.id).emit('MAKEFULLFIELD', data);
    })
});