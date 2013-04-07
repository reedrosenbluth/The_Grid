# TODO

## Server
- design protocol for communication with client
- send actors' locations and colors to client
- take inputs from client and transfer to movement in specific actors
- bugs dies on collision (Wall, Trail, and other Bug)
- Paint instructions to server
- when bug dies its trail disappear
- create Trails as an extension of Rock

## Client
- receive data from server
- choose bug color
- show grid and populate with data from server
- receive input to Paint

##Commands
- Paint: [special character] [x-cord] [y-cord] [color]