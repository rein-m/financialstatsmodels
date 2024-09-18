# financialstatsmodels
calculating various statistical analysis estimates, designed to estimate the risk associated with a particular financial portfolio or asset. 

IMPORTANT: don't use these indicators or these scripts as your entire trading strategy, you will lose money. also, this is not intended to be a given trading strategy for the reader to use (don't sue me).

VaR stands for Value at Risk, and it is a measure of the maximum potential loss that an investment portfolio or individual asset is likely to experience over a given time period, with a specified level of confidence

RSI is a Relative Strength Index, which are used to show strength of a (mostly US) traded equity, ETF, or future relative to past performance. 
"The relative strength index (RSI) is a technical indicator used in stock trading analysis to measure the strength of a stock's price action by comparing the magnitude of recent gains to recent losses in an attempt to determine overbought and oversold conditions of an asset.
The RSI is calculated using a formula that takes into account the average gain and average loss over a specified time period. The resulting value ranges from 0 to 100, with a value of 70 or above indicating an overbought condition and a value of 30 or below indicating an oversold condition."

The Black-Scholes model is a mathematical formula used to estimate the price of a European call or put option on a stock or other financial asset. It was developed by Fischer Black and Myron Scholes in 1973 and has become a widely used tool in finance and investment management.
The model makes several simplifying assumptions, including that the stock price follows a lognormal distribution, the risk-free interest rate is constant, and there are no transaction costs or taxes. Under these assumptions, the model calculates the theoretical value of an option by taking into account the stock price, strike price, time to expiration, risk-free interest rate, and volatility of the underlying stock.

^This Black-Scholes model is a somewhat innacurate first pass, as I didn't calculate the error function exactly; I used approximation weights to get 'close' to accurate.

(what is close, really? probably more stringent if you work at a trading firm :) )
