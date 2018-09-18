# -*- coding: utf-8 -*-
"""
Created on Tue Jul 31 18:20:46 2018

@author: Ankit Varshney
"""
import pandas as pa

path = r'D:\Documents\Study\Dalhousie\Summer2018\Data\Project\Dataset\worldcitiespop.txt';
df = pa.read_csv(path, encoding = "ISO-8859-1", error_bad_lines=False)
df_ca = pa.DataFrame()
appended_data = []

for index, rowvalue in df.iterrows():
    if "ca" in rowvalue[0]:
        print(rowvalue[1])
        break;

    
df_ca.to_csv('appended.csv')