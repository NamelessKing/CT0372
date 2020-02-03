package it.myImplementations.class_exercises.Breakout;

import static it.myImplementations.class_exercises.Breakout.Brick.Type.*;

public final class Levels {
    
    public static final Brick.Type[][]
            
    classic_1 = { 
        
    { steel  , steel  , steel  , steel  , steel  , steel  , steel  , steel  , steel  , steel  , steel  , steel  , steel   }, 
    { red    , red    , red    , red    , red    , red    , red    , red    , red    , red    , red    , red    , red     }, 
    { yellow , yellow , yellow , yellow , yellow , yellow , yellow , yellow , yellow , yellow , yellow , yellow , yellow  }, 
    { blue   , blue   , blue   , blue   , blue   , blue   , blue   , blue   , blue   , blue   , blue   , blue   , blue    }, 
    { magenta, magenta, magenta, magenta, magenta, magenta, magenta, magenta, magenta, magenta, magenta, magenta, magenta }, 
    { green  , green  , green  , green  , green  , green  , green  , green  , green  , green  , green  , green  , green   }, 
    
    },
    
    classic_2 = { 
        
    { yellow , null   , null   , null   , null   , null   , null   , null   , null   , null   , null   , null   , null    }, 
    { yellow , white  , null   , null   , null   , null   , null   , null   , null   , null   , null   , null   , null    }, 
    { yellow , white  , cyan   , null   , null   , null   , null   , null   , null   , null   , null   , null   , null    }, 
    { yellow , white  , cyan   , green  , null   , null   , null   , null   , null   , null   , null   , null   , null    }, 
    { yellow , white  , cyan   , green  , red    , null   , null   , null   , null   , null   , null   , null   , null    }, 
    { yellow , white  , cyan   , green  , red    , blue   , null   , null   , null   , null   , null   , null   , null    }, 
    { yellow , white  , cyan   , green  , red    , blue   , magenta, null   , null   , null   , null   , null   , null    }, 
    { yellow , white  , cyan   , green  , red    , blue   , magenta, yellow , null   , null   , null   , null   , null    }, 
    { yellow , white  , cyan   , green  , red    , blue   , magenta, yellow , white  , null   , null   , null   , null    }, 
    { yellow , white  , cyan   , green  , red    , blue   , magenta, yellow , white  , cyan   , null   , null   , null    }, 
    { yellow , white  , cyan   , green  , red    , blue   , magenta, yellow , white  , cyan   , green  , null   , null    }, 
    { yellow , white  , cyan   , green  , red    , blue   , magenta, yellow , white  , cyan   , green  , red    , null    }, 
    { steel  , steel  , steel  , steel  , steel  , steel  , steel  , steel  , steel  , steel  , steel  , steel  , blue    }
    
    },
    
    four_blocks = { 
        
    { steel, null  }, 
    { red  , null  }
                        
    },
    
    single_block = { 
        
    { null , null , null  }, 
    { null , steel, null  }, 
    { null , null , null  }
    
    };
    
    public final static Brick.Type[][][]
            
    classic_set = { classic_1, classic_2 },
            
    test_set = { four_blocks, single_block };
    
    public final static String[] textures_set_1 = { "texture1.jpg" ,"texture2.jpg" };
    
}
