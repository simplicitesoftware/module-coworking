<!--
 ___ _            _ _    _ _    __
/ __(_)_ __  _ __| (_)__(_) |_ /_/
\__ \ | '  \| '_ \ | / _| |  _/ -_)
|___/_|_|_|_| .__/_|_\__|_|\__\___|
            |_| 
-->
![](https://docs.simplicite.io//logos/logo250.png)
* * *

`Coworking` module definition
=============================



`CowBooking` business object definition
---------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `cowBookBookingNumber`                                       | int(100)                                 | yes*     | yes       |          | -                                                                                |
| `cowBookCusId` link to **`CowCustomers`**                    | id                                       | yes      | yes       |          | -                                                                                |
| _Ref. `cowBookCusId.cowCusFirstName`_                        | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `cowBookCusId.cowCusName`_                             | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `cowBookCusId.cowCusBirthDate`_                        | _date_                                   |          |           |          | -                                                                                |
| _Ref. `cowBookCusId.cowCusPhoneNumber`_                      | _phone(10)_                              |          |           |          | -                                                                                |
| _Ref. `cowBookCusId.cowCusMail`_                             | _email(50)_                              |          |           |          | -                                                                                |
| `cowBookRoomId` link to **`CowRoom`**                        | id                                       | yes      | yes       |          | -                                                                                |
| _Ref. `cowBookRoomId.cowRoomFloor`_                          | _char(3)_                                |          |           |          | -                                                                                |
| _Ref. `cowBookRoomId.cowRoomBuiId`_                          | _id_                                     |          |           |          | -                                                                                |
| _Ref. `cowRoomBuiId.cowBuiName`_                             | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `cowRoomBuiId.cowBuiOpeningTime`_                      | _time_                                   |          |           |          | -                                                                                |
| _Ref. `cowRoomBuiId.cowBuiAdress`_                           | _text(1000)_                             |          |           |          | -                                                                                |
| _Ref. `cowBookRoomId.cowRoomNumber`_                         | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `cowRoomBuiId.cowBuiClosingTime`_                      | _time_                                   |          |           |          | -                                                                                |
| `cowBookStatus`                                              | enum(100) using `COWBOOKSTATUS` list     | yes      | yes       |          | -                                                                                |
| _Ref. `cowBookRoomId.cowRoomCapacity`_                       | _int(100)_                               |          |           |          | -                                                                                |
| `cowBookDate`                                                | date                                     | yes      | yes       |          | -                                                                                |
| `cowBookBeginningTime`                                       | time                                     | yes      | yes       |          | -                                                                                |
| `cowBookEndingTime`                                          | time                                     | yes      | yes       |          | -                                                                                |
| `cowBookNotDisponible`                                       | text(100)                                |          |           |          | -                                                                                |

### Lists

* `COWBOOKSTATUS`
    - `PENDING` 
    - `CONFIRM` Confirmed
    - `CANCEL` Cancelled

### Custom actions

* `COW_CHECK_TIMING`: 

`CowBuilding` business object definition
----------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `cowBuiName`                                                 | char(100)                                | yes*     | yes       |          | -                                                                                |
| `cowBuiAdress`                                               | text(1000)                               | yes*     | yes       |          | -                                                                                |
| `cowBuiOpeningTime`                                          | time                                     |          | yes       |          | -                                                                                |
| `cowBuiClosingTime`                                          | time                                     |          | yes       |          | -                                                                                |
| `cowBuiPicture`                                              | image                                    |          | yes       |          | -                                                                                |

`CowCustomers` business object definition
-----------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `cowCusFirstName`                                            | char(100)                                | yes*     | yes       |          | -                                                                                |
| `cowCusName`                                                 | char(100)                                | yes*     | yes       |          | -                                                                                |
| `cowCusBirthDate`                                            | date                                     | yes*     | yes       |          | -                                                                                |
| `cowCusMail`                                                 | email(50)                                | yes      | yes       |          | -                                                                                |
| `cowCusPhoneNumber`                                          | phone(10)                                | yes      | yes       |          | -                                                                                |
| `cowCusPassword`                                             | password(100)                            | yes      | yes       |          | -                                                                                |

`CowEligibleOptions` business object definition
-----------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `cowEliRoomId` link to **`CowRoom`**                         | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `cowEliRoomId.cowRoomNumber`_                          | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `cowEliRoomId.cowRoomFloor`_                           | _char(3)_                                |          |           |          | -                                                                                |
| _Ref. `cowEliRoomId.cowRoomBuiId`_                           | _id_                                     |          |           |          | -                                                                                |
| _Ref. `cowRoomBuiId.cowBuiName`_                             | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `cowRoomBuiId.cowBuiAdress`_                           | _text(1000)_                             |          |           |          | -                                                                                |
| `cowEliOptId` link to **`CowOptions`**                       | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `cowEliOptId.cowOptOptionName`_                        | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `cowEliOptId.cowOptDescription`_                       | _text(100)_                              |          |           |          | -                                                                                |

`CowOptions` business object definition
---------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `cowOptOptionName`                                           | char(100)                                | yes*     | yes       |          | -                                                                                |
| `cowOptDescription`                                          | text(100)                                |          | yes       |          | -                                                                                |

`CowOptionsLine` business object definition
-------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `cowOptlBookId` link to **`CowBooking`**                     | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `cowOptlBookId.cowBookBookingNumber`_                  | _int(100)_                               |          |           |          | -                                                                                |
| _Ref. `cowOptlBookId.cowBookCusId`_                          | _id_                                     |          |           |          | -                                                                                |
| _Ref. `cowBookCusId.cowCusName`_                             | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `cowBookCusId.cowCusBirthDate`_                        | _date_                                   |          |           |          | -                                                                                |
| _Ref. `cowBookCusId.cowCusFirstName`_                        | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `cowOptlBookId.cowBookRoomId`_                         | _id_                                     |          |           |          | -                                                                                |
| _Ref. `cowBookRoomId.cowRoomFloor`_                          | _char(3)_                                |          |           |          | -                                                                                |
| _Ref. `cowBookRoomId.cowRoomBuiId`_                          | _id_                                     |          |           |          | -                                                                                |
| _Ref. `cowBookRoomId.cowRoomNumber`_                         | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `cowRoomBuiId.cowBuiAdress`_                           | _text(1000)_                             |          |           |          | -                                                                                |
| _Ref. `cowRoomBuiId.cowBuiName`_                             | _char(100)_                              |          |           |          | -                                                                                |
| `cowOptlEliId` link to **`CowEligibleOptions`**              | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `cowOptlEliId.cowEliRoomId`_                           | _id_                                     |          |           |          | -                                                                                |
| _Ref. `cowEliRoomId.cowRoomNumber`_                          | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `cowEliRoomId.cowRoomFloor`_                           | _char(3)_                                |          |           |          | -                                                                                |
| _Ref. `cowEliRoomId.cowRoomBuiId`_                           | _id_                                     |          |           |          | -                                                                                |
| _Ref. `cowRoomBuiId.cowBuiAdress`_                           | _text(1000)_                             |          |           |          | -                                                                                |
| _Ref. `cowRoomBuiId.cowBuiName`_                             | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `cowOptlEliId.cowEliOptId`_                            | _id_                                     |          |           |          | -                                                                                |
| _Ref. `cowEliOptId.cowOptOptionName`_                        | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `cowEliOptId.cowOptDescription`_                       | _text(100)_                              |          |           |          | -                                                                                |

`CowPrivateSpace` business object definition
--------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|

`CowPublicSpace` business object definition
-------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|

`CowRequest` business object definition
---------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `cowReqWorId` link to **`CowWorkspace`**                     | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `cowReqWorId.cowWorSeatNumber`_                        | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `cowReqWorId.cowWorStatus`_                            | _enum(100) using `COWWORSTATUS` list_    |          |           |          | -                                                                                |
| _Ref. `cowReqWorId.cowWorAvailability`_                      | _boolean_                                |          |           |          | -                                                                                |
| _Ref. `cowReqWorId.cowWorBuiId`_                             | _id_                                     |          |           |          | -                                                                                |
| _Ref. `cowWorBuiId.cowBuiName`_                              | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `cowWorBuiId.cowBuiAdress`_                            | _text(1000)_                             |          |           |          | -                                                                                |
| `cowReqCusId` link to **`CowCustomers`**                     | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `cowReqCusId.cowCusFirstName`_                         | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `cowReqCusId.cowCusName`_                              | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `cowReqCusId.cowCusBirthDate`_                         | _date_                                   |          |           |          | -                                                                                |
| _Ref. `cowReqCusId.cowCusPhoneNumber`_                       | _phone(10)_                              |          |           |          | -                                                                                |
| _Ref. `cowReqCusId.cowCusMail`_                              | _email(50)_                              |          |           |          | -                                                                                |
| `cowReqStatus`                                               | enum(100) using `COWREQSTATUS` list      | yes      | yes       |          | -                                                                                |

### Lists

* `COWWORSTATUS`
    - `PUBLIC` Public
    - `PRIVATE` Private
* `COWREQSTATUS`
    - `WAITLIST` Waitlist
    - `ACCEPTED` Accepted
    - `CANCELLED` Cancelled

`CowRoom` business object definition
------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `cowRoomNumber`                                              | char(100)                                | yes*     | yes       |          | -                                                                                |
| `cowRoomFloor`                                               | char(3)                                  | yes*     | yes       |          | -                                                                                |
| `cowRoomCapacity`                                            | int(100)                                 | yes      | yes       |          | -                                                                                |
| `cowRoomBuiId` link to **`CowBuilding`**                     | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `cowRoomBuiId.cowBuiName`_                             | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `cowRoomBuiId.cowBuiAdress`_                           | _text(1000)_                             |          |           |          | -                                                                                |
| _Ref. `cowRoomBuiId.cowBuiOpeningTime`_                      | _time_                                   |          |           |          | -                                                                                |
| _Ref. `cowRoomBuiId.cowBuiClosingTime`_                      | _time_                                   |          |           |          | -                                                                                |

`CowWorkspace` business object definition
-----------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `cowWorSeatNumber`                                           | char(100)                                | yes*     | yes       |          | -                                                                                |
| `cowWorAvailability`                                         | boolean                                  | yes      |           |          | -                                                                                |
| `cowWorStatus`                                               | enum(100) using `COWWORSTATUS` list      | yes*     | yes       |          | -                                                                                |
| `cowWorBuiId` link to **`CowBuilding`**                      | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `cowWorBuiId.cowBuiName`_                              | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `cowWorBuiId.cowBuiAdress`_                            | _text(1000)_                             |          |           |          | -                                                                                |

### Lists

* `COWWORSTATUS`
    - `PUBLIC` Public
    - `PRIVATE` Private

### Custom actions

* `COW_UPDATE_AVAILABILITY`: 

`CowBuiMaps` external object definition
---------------------------------------




