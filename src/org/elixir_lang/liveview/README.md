# Phoenix Liveview functionalities

 * Liveview templates are not another language : they are html with xml tags for liveview components, and eex usage in html tags
 * We are not creating a bnf and flex files for handling them
 * We don't want to depends on Javascript plugin, as the Elixir plugin wouldn't be able to run on OS IDEs

## Multiple ways to implement

   * Some plugins define template languages, I tried experimenting with extending HTML, but without success.
   * The Angular plugin makes a full language with lexer and parser, redefining html at the same time. This is the way the liveview tokenizer works, so I will try this approach first.

## Functionalities to implement

 * [ ] Discover html heex files
 * [ ] Find related .ex files
 * [ ] Handle ~H sigils
 * [ ] Tokens, attributes
 * [ ] Handle .ex components
 * [ ] Navigate to component from a template