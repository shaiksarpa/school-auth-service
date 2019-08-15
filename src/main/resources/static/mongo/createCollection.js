use admissionDB;

db.createCollection("admissionRecord",{});

db.admissionRecord.createIndex({"admissionNumber":1}, { unique: true } );
