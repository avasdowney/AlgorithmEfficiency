import pandas as pd
import random
import numpy as np

df = pd.DataFrame(np.random.randint(0,5000,size=(5000, 1)), columns=list('n'))

df.to_csv("input2.txt", index = False, header=None)