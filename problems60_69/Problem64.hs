import Data.List
import Data.Maybe

data Frac = Frac {num :: Int, sq_floor :: Int, denom_nat :: Int, denom_sq :: Int} deriving (Show, Eq)

sq' n = n * n

conj sq_n nat = sq_n - (sq' nat)

gnn_h n d fl acc
    | fl + n - d < 0 = (n, acc)
    | otherwise = gnn_h (n -d) d fl (acc + 1)

get_next_num :: Frac -> (Int, Frac)
get_next_num fr =
    let n_denom = (conj (denom_sq fr) (denom_nat fr)) `quot` (num fr) 
        tup = gnn_h (abs $ denom_nat fr) n_denom (sq_floor fr) 0
    in (snd tup, Frac (n_denom) (sq_floor fr) (fst tup) (denom_sq fr))

get_period :: Frac -> [Frac] -> Int 
get_period fr fr_acc =
    let tup = get_next_num fr
    in case elem (snd tup) fr_acc of True -> (fromJust $ elemIndex (snd tup) fr_acc) + 1
                                     False -> get_period (snd tup) ((snd tup):fr_acc)

get_initial_frac sq =
    let fl = floor $ sqrt $ fromIntegral sq
    in Frac 1 fl (fl * (-1)) sq

get_p_auto q = get_period (get_initial_frac q) []

main = 
    let sqs = [ x * x | x <- [1 .. (ceiling $ sqrt $ 10000)]]
        all = [1..10000]
	not_sqs = all \\ sqs
	answer = map get_p_auto not_sqs
	answer_filt = [ x | x <- answer, x `mod` 2 == 1]
    in do putStrLn $ show $ answer_filt
          putStrLn $ show $ length answer_filt
        

