select ITEM_ID,	ITEM_NAME, RARITY
from ITEM_INFO
where ITEM_ID in
    (
        select T.ITEM_ID
        from ITEM_INFO I , ITEM_TREE T
        where (I.ITEM_ID = T.PARENT_ITEM_ID) and I.RARITY = "RARE"
    )
order by ITEM_ID desc