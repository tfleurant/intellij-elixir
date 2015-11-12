// This is a generated file. Not intended for manual editing.
package org.elixir_lang.psi;

import com.ericsson.otp.erlang.OtpErlangObject;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ElixirUnmatchedQualifiedParenthesesCall extends ElixirUnmatchedExpression, QualifiedParenthesesCall {

  @Nullable
  ElixirDoBlock getDoBlock();

  @NotNull
  ElixirDotInfixOperator getDotInfixOperator();

  @NotNull
  ElixirMatchedParenthesesArguments getMatchedParenthesesArguments();

  @NotNull
  ElixirRelativeIdentifier getRelativeIdentifier();

  @NotNull
  ElixirUnmatchedExpression getUnmatchedExpression();

  @Nullable
  String functionName();

  ASTNode functionNameNode();

  @Nullable
  String moduleName();

  @NotNull
  OtpErlangObject quote();

  @NotNull
  String resolvedFunctionName();

  @NotNull
  String resolvedModuleName();

}
