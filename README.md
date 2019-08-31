README for NYTimes style tile game

**Game Description**
This game is designed to play like the NYTimes game where you have to match 
patterns on different tiles in order to make them disappear, and you win once 
all elements are gone from all tiles. 

**How to use the Program**
For this version, all you have to do is double click TileGame.jar in the main
directory. Or if you want to use the command line you can use the following 
command "java -jar TileGame.jar". This will find the main class, untuitively 
named Main and the game will launch from there. 

**_Issues/Concerns_**

**A word on the 1st version board production**
The board that is generated in the first version of the game is populated 
entirely by identical tiles in order to guarantee a winnable game and show 
that all functionality works fine. 

**Tile Highlight Functionality**
The highlighting of the selected tile works, but the coloration changes 
depending on what has occurred. If you click an empty tile, it turns black. This
is consistent, but sometimes the color can reflect elements that are on a tile
that you have newly selected. 

**Being able to highlight empty tiles**
In version 1 you can select empty tiles and end your streak this way. I 
personally like having this extra element of paying attention, but in order
to perfectly mimic the NYTimes version, future versions will have to disable
this ability. 
