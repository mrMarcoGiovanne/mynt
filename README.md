# Java Programming Exam
## Mynt

### Default API Sample
```
POST localhost:8080/api/mynt/default?voucherCode=MYNT
```

Request Body Sample
```json
{
	"weight": 9,
	"height": 1,
	"width": 1,
	"length": 1000
}
```

Response Sample
```json
{
    "data": {
        "result": {
            "cost": 30.00,
            "discount": 12.25,
            "total": 17.75
        },
        "message": "Small Parcel",
        "errors": []
    }
}
```

### With Rules API
```
POST localhost:8080/api/mynt
```

Request Body Sample
```json
{
    "weight": {
    	"unit" : "kg",
    	"value": 9
    },
    "height": {
    	"unit": "cm",
    	"value": 1
    },
    "width": {
    	"unit": "cm",
    	"value": 1
    },
    "length": {
    	"unit": "cm",
    	"value": 1000
    },
    "other": {
    	"rules": [
    		{
    			"priority" : 1,
    			"cost": 0,
    			"quantity": "weight",
    			"conditionLimit": 50
    		},
    		{
    			"priority" : 2,
    			"cost": 20,
    			"quantity": "weight",
    			"conditionLimit": 10
    		},
    		{
    			"priority" : 3,
    			"cost": 0.03,
    			"quantity": "volume",
    			"conditionLimit": 1500
    		},
    		{
    			"priority" : 4,
    			"cost": 0.04,
    			"quantity": "volume",
    			"conditionLimit": 2500
    		},
    		{
    			"priority" : 5,
    			"cost": 0.05,
    			"quantity": "volume",
    			"conditionLimit": 0
    		}
    	],
        "voucherCode": "MYNT"
    }
}
```

Response Sample
```json
{
    "data": {
        "result": {
            "cost": 30.00,
            "discount": 12.25,
            "total": 17.75
        },
        "message": "Small Parcel",
        "errors": []
    }
}
```
