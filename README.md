# debate_counter_arguments
When evidence is given by a team in the context of a larger piece of text, this code automatically scans it and tries to find counter arguments to the evidence in the same piece of text.

Uses 2 alternative methods: simple keyword based (Contradictions.java), and NLP based (WitNLPQuery.java). The NLP version queries the NLP model trained on wit.ai and accessed through the https://api.wit.ai/message API. The nlp model built and trained online is a more scalable way to find the counter argument keywords, and can be extended to more complex cases in the future.

Also included is a sample input file with typical arguments.
