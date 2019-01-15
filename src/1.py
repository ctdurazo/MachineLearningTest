from sklearn import tree

features = [[140,130,120,140],[130,14,180,100],[140,130,120,5],[130,14,180,10]]
labels = [0,0,1,1]

clf = tree.DecisionTreeClassifier()
clf = clf.fit(features, labels)

print(clf.predict([[160,150,120,100]]))