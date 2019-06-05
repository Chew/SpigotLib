package gyurix.economy.custom;

import gyurix.economy.BalanceData;
import gyurix.spigotlib.SU;

import java.math.BigDecimal;
import java.util.UUID;

public class BalanceType extends BalanceData {
  public BalanceType(BalanceData bd) {
    super(bd);
  }

  public BigDecimal get(UUID plr) {
    BigDecimal bd = SU.getPlayerConfig(plr).getObject("balance." + name, BigDecimal.class);
    return bd == null ? defaultValue : bd;
  }

  public BigDecimal getBank(String bank) {
    BigDecimal bd = SU.pf.getObject("bankbalance." + bank + "." + name, BigDecimal.class);
    return bd == null ? defaultValue : bd;
  }

  public boolean set(UUID plr, BigDecimal value) {
    SU.getPlayerConfig(plr).setObject("balance." + name, value);
    return true;
  }

  public boolean setBank(String bank, BigDecimal value) {
    SU.pf.setObject("bankbalance." + bank + "." + name, value);
    return true;
  }
}
