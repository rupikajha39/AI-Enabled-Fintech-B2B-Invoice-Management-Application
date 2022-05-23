import React from "react";
import logo from "../../assets/logo.png";
import logoABC from "../../assets/logoABC.png";

const Header = () => {
  return (
    <header>
      <img src={logo} alt="logo" className="logo primary" />
      <img src={logoABC} alt="logo" className="logo secondary" />
    </header>
  );
};

export default Header;
