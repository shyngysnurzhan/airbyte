/*
 * Copyright (c) 2021 Airbyte, Inc., all rights reserved.
 */

package io.airbyte.integrations.destination.snowflake;

import io.airbyte.integrations.destination.ExtendedNameTransformer;

public class SnowflakeSQLNameTransformer extends ExtendedNameTransformer {

  @Override
  public String applyDefaultCase(final String input) {
    return input.toUpperCase();
  }

  /**
   * The first character can only be alphanumeric or an underscore.
   */
  @Override
  public String getIdentifier(final String name) {
    final String normalizedName = super.getIdentifier(name);
    if (normalizedName.substring(0, 1).matches("[A-Za-z_]")) {
      return normalizedName;
    } else {
      return "_" + normalizedName;
    }
  }

}
