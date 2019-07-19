sq n = n * n
main = do
	putStrLn $ show ((sq (foldl (+) 0 [1..100])) - (foldl (+) 0 (map (\x->x*x) [1..100])))
