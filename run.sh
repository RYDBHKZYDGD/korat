ant createJar
cp dist/korat.jar lib/
java -cp "lib/*" korat.Korat --visualize --class korat.examples.graph.Graph  --args 3
