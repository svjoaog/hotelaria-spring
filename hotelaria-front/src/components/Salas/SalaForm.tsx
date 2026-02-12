import { useEffect, useState } from "react";
import api from "../../api/axios";
import { type Sala } from "../../types/Sala";
import { type Setor } from "../../types/Setor";

interface Props{
    salaSelecionada: Sala | null;
    onSucesso: () => void;
}

export function SalaForm({salaSelecionada, onSucesso}: Props){
    const [nome, setNome] = useState("");
    const [setorId, setSetorId] = useState<number>(0);
    const [setores, setSetores] = useState<Setor[]>([]);

    useEffect(() => {
        api.get<Setor[]>("/setores")
            .then(res => setSetores(res.data));
    }, []);

    useEffect(() => {
        if(salaSelecionada){
            setNome(salaSelecionada.nome);
            setSetorId(salaSelecionada.setorId);
        } else{
            setNome("");
            setSetorId(0);
        }
    }, [salaSelecionada])

    function salvar(e: React.FormEvent){
        e.preventDefault();

        const sala = {nome, setorId};

        if(salaSelecionada?.id){
            api.put(`/salas/${salaSelecionada.id}`, {sala})
                .then(onSucesso);
        } else{
            api.post("/salas", {sala})
                .then(onSucesso);
        }
    }

    return(
        <form onSubmit={salvar}>
            <input
                placeholder="Nome da sala"
                value={nome}
                onChange={e => setNome(e.target.value)}
                required
            />

            <select
                value={setorId}
                onChange={e => setSetorId(Number(e.target.value))}
                required
            >
                <option value={""}>Selecione o setor</option>

                {setores.map(setor => (
                    <option key={setor.id} value={setor.id}>
                        {setor.name}
                    </option>
                ))}
            </select>

            <button type="submit">
                {salaSelecionada ?  "Atualizar" : "Cadastrar"}
            </button>
        </form>
    );
}