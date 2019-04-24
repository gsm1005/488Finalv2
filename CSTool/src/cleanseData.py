import pandas as pd
import numpy as np
from pandas import ExcelWriter
from pandas import ExcelFile


nullValues=["n/a","na","--"]
df = pd.read_excel('ctu13-1.xlsx', sheet_name='book2',na_values=nullValues)
cnt=0
for row in df['Label']:
    try:
        int(row)
        df.loc[cnt, 'Label']=np.nan
    except ValueError:
        pass
    cnt+=1;
    
mylist = df['Label'].tolist()
mylist2 = df['TotPkts'].tolist()

df = pd.DataFrame.from_dict({'flows':mylist})
df = pd.DataFrame.from_dict({'totalPackets':mylist2})
df.to_excel('flows.xlsx', header=True, index=False)

