select ID, LENGTH
from FISH_INFO
where LENGTH is not NUlL
order by LENGTH DESC, ID
limit 10