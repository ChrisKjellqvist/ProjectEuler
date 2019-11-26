psum bin depth acc collapse =
    let nacc = ((depth + 1) * acc) + collapse
	modbin = mod bin 2
	quotbin = quot bin 2
    in case modbin of
        1 ->                           psum quotbin 0            nacc (nacc - acc)
	0 -> if bin == 0 then acc else psum quotbin (succ depth) acc  collapse

f n = psum n 0 1 0

main =
    do putStrLn $ show $ f 10^2500000
