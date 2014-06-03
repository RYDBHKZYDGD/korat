ant createJar
cp dist/korat.jar lib/
java -cp "lib/*" korat.Korat --visualize --class korat.examples.searchtree.SearchTree  --args 3,3,3,0,2
