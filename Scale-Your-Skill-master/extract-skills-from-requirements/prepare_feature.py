# -*- coding: utf-8 -*-
"""
Created on Wed Jul 25 15:30:48 2018

@author: Ankit Varshney
"""

import pandas as pa

path = r'D:\Documents\Study\Dalhousie\Summer2018\Data\Project\us_jobs.csv';
df = pa.read_csv(path, encoding = "ISO-8859-1", error_bad_lines=False)
path1 = r'D:\Documents\Study\Dalhousie\Summer2018\Data\Project\Dataset\skills_new.csv';
df_skills = pa.read_csv(path1, encoding = "ISO-8859-1")


df_final = pa.DataFrame([])

final = {}
lastval = []
df_final = pa.DataFrame([])
for index, row in df_skills.iterrows():
    for x,i in enumerate(row):
        final[i] = x
                
for index, rowvalue in df.iterrows():
    df_new = []
    print(rowvalue[0])
    row_split = str(rowvalue[0]).split(' ')
    for value in row_split:
        if value in final.keys():
            df_new.append(value.lower())
            print(df_new)
    str1 = ' '.join(df_new)
    lastval.append(str1)

skills = pa.DataFrame(data=lastval, columns=["feature"])
df = skills.to_csv('new_feature.csv',header=['feature'], index=False)

    


