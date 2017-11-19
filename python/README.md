The loader depends on the names of the files containing the lightcurves being in the OGLE periodic catalog format:  
OGLE-{area}-{type}-{number}.dat  
Make sure the filenames passed as arguments conform to that format, or modify the following functions:  
get_type()  
get_filename()  
load()  
