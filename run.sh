ant createJar
cp dist/korat.jar lib/
java -cp "lib/alloy.jar:lib/cli.jar:lib/korat.jar" korat.Korat -d  --class korat.examples.graph.Graph  --args 3
